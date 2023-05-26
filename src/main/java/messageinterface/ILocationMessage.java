package messageinterface;


public interface ILocationMessage {
	
  public void setLocation(double latitude, double longitude) throws Exception;
  public String getLocation();
}
