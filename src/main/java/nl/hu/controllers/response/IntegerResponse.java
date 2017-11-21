package nl.hu.controllers.response;

/**
 * Created by rikde on 21/11/2017.
 */
public class IntegerResponse {
    private int response;

    public IntegerResponse(int response) {
        this.setResponse(response);
    }


    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
