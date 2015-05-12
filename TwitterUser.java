/**
 * This class contains all of the authentication data
 * as well as the methods for user action.
 */

import twitter4j.*;
import twitter4j.auth.AccessToken;

public class TwitterUser{
	//Application Data from Twitter Registration
	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessTokenSecret;
	
	//Initializes TwitterUser with key, token, and secrets
	public TwitterUser(){
		this.consumerKey = "tbnNIbnPltwNpQNQ0TC4VMRrd";
		this.consumerSecret = "ZyxWg1YsTOsfOUPFKmGHklUfUta4TGB3YWyj2djda9spVGwIIP";
		this.accessToken = "3192752882-tRy5jodUm7YByvjw7dprE1Tb2WFU3YFrVeq1xUX";
		this.accessTokenSecret = "UXoPUeatPkQ6URS8UTgZntVUbui1q0CEdJJfctSkJ4pzz";
	}
	
	/**
	 * Posts tweets to the CPSC353 twitter account and prints the server's
	 * response.
	 *
	 * @param String The text that you would like to tweet.
	 */
	public void postTweet(String tweet){
		
		//Confirm tweet is appropriate length
		if (tweet.length() <= 140){
			try{
				TwitterFactory factory = new TwitterFactory();
				Twitter twitter = factory.getInstance();
			
				//Provide authentication
				twitter.setOAuthConsumer(consumerKey, consumerSecret);
				twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
			
				//Updates the status for CPSC353
				StatusUpdate update = new StatusUpdate(tweet);
			
				//Saves the response from the twitter server
				Status status = twitter.updateStatus(update);
			
			
				System.out.println("status.toString() = " + status.toString());
				System.out.println("status.getInReplyToScreenName() = " + status.getInReplyToScreenName());
				System.out.println("status.getSource() = " + status.getSource());
				System.out.println("status.getText() = " + status.getText());
			}
			catch (TwitterException e){
				System.out.println(e.getMessage());
			}
		}
		else{
			System.out.println("Tweet is too long. Please try again.");
		}
	}
	
	/**
	 * A method or two can go here, Lauren.
	 */		
}