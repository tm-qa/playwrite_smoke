package Pages;

import base.TestBase;
import com.microsoft.playwright.*;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.files.FilesUploadV2Request;
import com.slack.api.methods.response.files.FilesUploadV2Response;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class a extends TestBase {

    private static String getTimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return LocalDateTime.now().format(formatter);
    }
    public void allureToSlack() throws IOException, InterruptedException, SlackApiException {
        String allureResultsPath = "/Users/tejasbahadure/Downloads/FrontendAutomation/target/allure-results";  // ✅ Update your exact path

        String slackToken = "xoxb-xxxxxxxxxx";  // ⚠️ replace with your Slack token
        String slackChannel = "C09CFEQ57PG";   // ⚠️ your Slack channel ID

        // Step 1: Run Allure serve command
        ProcessBuilder pb = new ProcessBuilder("allure", "serve", allureResultsPath);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        // Step 2: Wait for Allure server to start and grab URL
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String allureUrl = null;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (line.contains("Server started at <")) {
                int start = line.indexOf("http");
                int end = line.indexOf(">");
                allureUrl = line.substring(start, end);
                break;
            }
        }

        if (allureUrl == null) {
            System.err.println("❌ Failed to extract Allure report URL");
            return;
        }

        System.out.println("✅ Allure report URL: " + allureUrl);

        // Step 3: Launch Playwright and capture screenshot
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            Page page = browser.newPage();
            page.navigate(allureUrl + "#behaviors");

            page.waitForTimeout(7000); // wait for report to load fully


            String fileName = "allure_slack-" + getTimeStamp() + ".png";
            java.io.File screenshotFile = new java.io.File(fileName);
            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotFile.toPath()).setFullPage(true));

            browser.close();

            // Step 4: Send to Slack
            uploadToSlack(slackToken, slackChannel, screenshotFile);
        }
    }

    private static void uploadToSlack(String token, String channelId, java.io.File file)
            throws IOException, SlackApiException {

        Slack slack = Slack.getInstance();
        MethodsClient methods = slack.methods(token);

        FilesUploadV2Request.UploadFile uploadFile = new FilesUploadV2Request.UploadFile();
        uploadFile.setFile(file);
        uploadFile.setFilename(file.getName());
        uploadFile.setTitle("Allure Report Screenshot");
        uploadFile.setAltTxt("Allure Screenshot");

        FilesUploadV2Request request = FilesUploadV2Request.builder()
                .channel(channelId)
                .uploadFiles(Collections.singletonList(uploadFile))
                .build();

        FilesUploadV2Response response = methods.filesUploadV2(request);
        if (response.isOk()) {
            System.out.println("✅ Screenshot posted to Slack successfully.");
        } else {
            System.err.println("❌ Failed to upload screenshot to Slack: " + response.getError());
        }
    }
}
