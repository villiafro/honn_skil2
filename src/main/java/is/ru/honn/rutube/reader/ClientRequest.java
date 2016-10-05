package is.ru.honn.rutube.reader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by VilhjalmurAlex on 26/09/2016.
 * @Author Vilhjálmur Alex Hannesson and Höskuldur Ágústsson
 * @Date 26/09/2016
 */
public class ClientRequest
{

    /**
     * Constructor of a new ClientRequest
     */
    public ClientRequest() {}

    /**
     * Creates a new client to read the given url, reads all entities and returns them
     * @param url the url for the client to read from
     * @return the given file that was read
     */
    public String getRequest(String url)
    {
        Client client = ClientBuilder.newClient();
        Response response = client.target(url).request().get();

        String result = response.readEntity(String.class);
        client.close();

        return result;
    }

    /**
     * Creates a new client to read the given file, reads all entities and returns them
     * @param fileName the file for the client to read from
     * @return the given file that was read
     * @throws ReaderException if the file cannot be opened/found
     */
    public String getFileContent(String fileName) throws ReaderException
    {
        StringBuilder content = new StringBuilder();
        try
        {
            java.io.FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                content.append(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex)
        {
            String msg = "Unable to open file '" + fileName + "'";
            throw new ReaderException(msg, ex);
        }
        catch(IOException ex)
        {
            String msg = "Error reading file '" + fileName + "'";
            throw new ReaderException(msg, ex);
        }
        return content.toString();
    }

}