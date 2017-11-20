package subreport;

public class SampleContents {

  private String name;
  private String requestMessage;
  private String responseMessage;
  private String bfValue;
  private String afValue;

  public SampleContents(String name, String requestMessage, String responseMessage, String bfValue, String afValue) {
    this.name = name;
    this.requestMessage = requestMessage;
    this.responseMessage = responseMessage;
    this.bfValue = bfValue;
    this.afValue = afValue;
  }

  public String getName() {
    return name;
  }

  public String getRequestMessage() {
    return requestMessage;
  }

  public void setRequestMessage(String requestMessage) {
    this.requestMessage = requestMessage;
  }

  public String getResponseMessage() {
    return responseMessage;
  }

  public void setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
  }

  public String getBfValue() {
    return bfValue;
  }

  public void setBfValue(String bfValue) {
    this.bfValue = bfValue;
  }

  public String getAfValue() {
    return afValue;
  }

  public void setAfValue(String afValue) {
    this.afValue = afValue;
  }

}
