package kr.or.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleListDTO {
	private List<SampleDTO> list;
	
	public void SampleDTO() {
		list = new ArrayList<SampleDTO>();
	}
}
