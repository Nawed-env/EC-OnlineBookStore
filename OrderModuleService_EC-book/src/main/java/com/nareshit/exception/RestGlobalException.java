//package com.nareshit.exception;
//
//import java.net.HttpURLConnection;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Vector;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import com.nareshit.model.ErrorResponseMessage;
//import com.nareshit.utility.Constants;
//
//@ControllerAdvice
//public class RestGlobalException {
//
//	@ExceptionHandler(CustmerIDNotFoundException.class)
//	public ResponseEntity<Object> customerHandleException(CustmerIDNotFoundException ex) {
//
//		List<String> details = new ArrayList<>();
//		details.add("Error :Customer Id not found");
//		details.add("Detaild Message :" + ex.getLocalizedMessage());
//		details.add("Timestamp: " + System.currentTimeMillis());
//		ErrorResponseMessage error = new ErrorResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILURE,
//				"NOT-FOUND", details);
//		return ResponseEntity.ok(error);
//	}
//
//
//
//	@ExceptionHandler(noEnaughRecordsException.class)
//	public ResponseEntity<Object> noEnaughRecordsException(noEnaughRecordsException ex) {
//
//		Map<String,Object> hm = new HashMap<>();
//		hm.put("Error :","Id doesn't match with existing id");
//		hm.put("Detaild Message :", ex.getLocalizedMessage());
//		hm.put("Timestamp: " , System.currentTimeMillis());
//		ErrorResponseMessage errorMsg = new ErrorResponseMessage (HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILURE, "NOT-FOUND-RECORDS", hm);
//		return ResponseEntity.ok(errorMsg);
//	  }
//
//	@ExceptionHandler(BookIdNotFoundException.class)
//	public ResponseEntity<Object> BookIdNotFoundException(BookIdNotFoundException ex) {
//
//		Vector<Object> v=new Vector<>();
//		v.add("Error : Invalid Id or Id's data is not there!!");
//		v.add("Detaild Message :"+ ex.getLocalizedMessage());
//		v.add("Timestamp: " + System.currentTimeMillis());
//
//
//		ErrorResponseMessage errorRaises = new ErrorResponseMessage (HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILURE, "NOT-FOUND-RECORDS", v);
//		return ResponseEntity.ok(errorRaises);
//	}
//
//
//
//}
