package com.chain.android.contactbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;


public class ConnectServer {
	
	/* connect to server */
	private String connect(String url) {
		InputStream inputStream = null;
		String result = "";
		try {
			// create HttpClient
			HttpClient httpclient = new DefaultHttpClient();
			// make GET request to the given URL
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
			// receive response as inputstream
			inputStream = httpResponse.getEntity().getContent();
			// convert inputstream to string
			if (inputStream != null) {
				result = convertInputStreamToString(inputStream);
			} else {
				result = "error";
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}/* end connect to server */

	// convert inputstream to string
	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {

		BufferedReader bufferedreader = new BufferedReader(
				new InputStreamReader(inputStream, "UTF-8"), 8);
		String line = "";
		String result = "";
		while ((line = bufferedreader.readLine()) != null) {
			result += line;
		}
		inputStream.close();
		return result;
	}// end convert inputStream to string

	// post data////////////////////////////////////////////////////////////
	public String postData(String url, List<NameValuePair> nameValuePair) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);

		BufferedReader in = null;
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair,HTTP.UTF_8));
			HttpResponse response = httpClient.execute(httpPost);

			in = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			String page = sb.toString();
//			Log.i("Page data", page);
			return page;
		} catch (ClientProtocolException e) {

		} catch (IOException e) {

		}
		return null;
	}// /	
	
		
}/* end connect server class */
	
	
	

