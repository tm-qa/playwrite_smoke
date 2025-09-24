//package Pages;
//
//
//import base.TestBase;
//import com.slack.api.Slack;
//import com.slack.api.methods.MethodsClient;
//import com.slack.api.methods.SlackApiException;
//import com.slack.api.methods.request.files.FilesUploadV2Request;
//import com.slack.api.methods.response.files.FilesUploadV2Response;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.util.Collections;
//
//public class allure_Report extends TestBase {
//
//    public void  allureToSlack() throws IOException, InterruptedException, SlackApiException {
//        String allureResultsPath = "/Users/tejasbahadure/Downloads/FrontendAutomation/target/allure-results";  // ✅ Update your exact path
//
//        String slackToken = "xoxb-3421650064-9045032050087-CIp4aml1myLE9PFJVkdEx5gc";
//        String slackChannel = "C09CFEQ57PG";
//        // Step 1: Run Allure serve command
//        ProcessBuilder pb = new ProcessBuilder("allure", "serve", allureResultsPath);
//        pb.redirectErrorStream(true);
//        Process process = pb.start();
//
//        // Step 2: Wait for server to start
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line;
//        String allureUrl = null;
//
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//            if (line.contains("Server started at <")) {
//                int start = line.indexOf("http");
//                int end = line.indexOf(">");
//                allureUrl = line.substring(start, end);
//                break;
//            }
//        }
//
//        if (allureUrl == null) {
//            System.err.println("❌ Failed to extract Allure report URL");
//            return;
//        }
//
//        System.out.println("✅ Allure report URL: " + allureUrl);
//
//        // Step 3: Launch browser and capture screenshot
////        WebDriver driver = new ChromeDriver();
////        driver.get(allureUrl+"#behaviors");
//        page.navigate(allureUrl+"#behaviors");
//        Thread.sleep(7000); // Wait for report to load
//
//        java.io.File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        java.io. File destFile = new java.io.File("allure_slack - "+getTimeStamp()+".png");
//
//        String fileName = "allure_slack-" + getTimeStamp() + ".png";
//        page.screenshot(new Page.ScreenshotOptions()
//                .setPath(Paths.get(fileName))
//                .setFullPage(true));
//
//
//
//        Files.copy(screenshot.toPath(), destFile.toPath());
//
//        driver.quit();
//
//        // Step 4: Send to Slack
//        uploadToSlack(slackToken, slackChannel, destFile);
//    }
//
//    private static void uploadToSlack(String token, String channelId, java.io.File file)
//            throws IOException, SlackApiException {
//
//        Slack slack = Slack.getInstance();
//        MethodsClient methods = slack.methods(token);
//
//        FilesUploadV2Request.UploadFile uploadFile = new FilesUploadV2Request.UploadFile();
//        uploadFile.setFile(file);
//        uploadFile.setFilename(file.getName());
//        uploadFile.setTitle("Allure Report Screenshot");
//        uploadFile.setAltTxt("Allure Screenshot");
//
//        FilesUploadV2Request request = FilesUploadV2Request.builder()
//                .channel(channelId)
//                .uploadFiles(Collections.singletonList(uploadFile))
//                .build();
//
//        FilesUploadV2Response response = methods.filesUploadV2(request);
//        System.out.println("✅ Screenshot posted to Slack.");
//
//    }
//}
