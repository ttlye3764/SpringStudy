package kr.or.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	private Date date;
	
	// data변수가 util.date 타입이기 때문에 밑의 형식으로 값이 들어오면 에러가 나기때문에 바인딩 처리를 해줘야함
	//2020-01-22
}
