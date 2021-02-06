import java.util.List;

public class ZipcodeResponse {

    private String message;
    private List<Results> results;
    private Integer status;

    public ZipcodeResponse() {
    }

    public ZipcodeResponse(String message, List<Results> results, Integer status) {
        this.message = message;
        this.results = results;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public List<Results> getResults() {
        return results;
    }

    public Integer getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
