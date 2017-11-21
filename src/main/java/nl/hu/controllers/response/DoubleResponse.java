package nl.hu.controllers.response;

/**
 * Created by rikde on 21/11/2017.
 */
public class DoubleResponse {
    private double response;

    public DoubleResponse(double response) {
        this.setResponse(response);
    }


    public double getResponse() {
        return response;
    }

    public void setResponse(double response) {
        this.response = response;
    }
}
