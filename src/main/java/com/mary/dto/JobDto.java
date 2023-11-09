package com.mary.dto;

public class JobDto {
	private String job_code;
	private String job_name;
	
	@Override
	public String toString() {
		return job_code + "/" + job_name;
	}

	public String getJob_code() {
		return job_code;
	}

	public void setJob_code(String job_code) {
		this.job_code = job_code;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
}
