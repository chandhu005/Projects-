import java.util.HashMap;
import java.util.Random;

public class XUrlImpl implements XUrl
{
	HashMap<String,String> map=new HashMap<>();
	HashMap<String,Integer> map1=new HashMap<>();
	String generateShortUrl()
	{
		 int lengthOfRandomString = 9;
	      Random rand = new Random();
	      String alphaNumericCharacters = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJLMNOPQRSTUVWXYZ" + "1234567890";
	 
	      // Use StringBuilder in place of String to avoid unnecessary object formation
	      StringBuilder result = new StringBuilder();	      
	      for (int i =0; i< lengthOfRandomString ; i++)
	      {
	           result.append(alphaNumericCharacters.charAt(rand.nextInt(alphaNumericCharacters.length())));
	      }
		return result.toString();		
	}
	 // If longUrl already has a corresponding shortUrl, return that shortUrl
	  // If longUrl is new, create a new shortUrl for the longUrl and return it
	 public String registerNewUrl(String longUrl)
	 {
		 for(String url:map.keySet())
		 {
			 if(longUrl.equals(url))
			 {
				 return map.get(url);
			 }
		 }
		 
		 String str=generateShortUrl();
		 map.put(longUrl,str);
		 return str;
		 
	 }
	// If shortUrl is already present, return null
	  // Else, register the specified shortUrl for the given longUrl
	  // Note: You don't need to validate if longUrl is already present, 
	  //       assume it is always new i.e. it hasn't been seen before 
	 public String registerNewUrl(String longUrl,String shortUrl)
	 {
		 for(String url:map.values())
		 {
			 if(shortUrl.equals(url))
			 {
				 return null;
			 }
		 }
		 map.put(longUrl,shortUrl);
		 
		return shortUrl;
	 }
	  // If shortUrl doesn't have a corresponding longUrl, return null
	    // Else, return the corresponding longUrl
	 public String getUrl(String shortUrl) 
	 {
		 for(String url:map.keySet())
		 {
			 if(shortUrl.equals(map.get(url)))
			 {
				if(map.containsKey(url))
				{
					map1.put(url,map1.get(url)+1);
					return url;
				}
				else
				{
					map1.put(url,1);
				}
				
			 }
		 }
		 return null;
	 }  
	 // Return the number of times the longUrl has been looked up using getUrl()
	  public Integer getHitCount(String longUrl)
	  {
	 if(map1.containsKey(longUrl))
	 {
		 return map1.get(longUrl);
	 }
	 return 0;
	  }

	  public String delete(String longUrl)
	  {
		  map.remove(longUrl);
	      return longUrl;
	  }
	
	
}
