package calculator.service;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class GoogleSheetsService {
    private static final String APPLICATION_NAME = "Google Sheets Calculator";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "C:\\Users\\maxff\\Desktop\\JavaLearning\\Chapter14\\VarBEx5\\src\\main\\java\\resources\\credentials.json";

    private final Sheets sheetsService;

    public GoogleSheetsService() throws IOException {
        this.sheetsService = createSheetsService();
    }

    public List<List<Object>> getValues(String spreadsheetId, String range) throws IOException {
        ValueRange response = sheetsService.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        return response.getValues();
    }

    private static Sheets createSheetsService() throws IOException {
        FileInputStream credentialsFileInputStream = new FileInputStream(CREDENTIALS_FILE_PATH);
        GoogleCredentials credentials = ServiceAccountCredentials.fromStream(credentialsFileInputStream)
                .createScoped(List.of("https://www.googleapis.com/auth/spreadsheets"));
        return new Sheets.Builder(new NetHttpTransport(), JSON_FACTORY, new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}
