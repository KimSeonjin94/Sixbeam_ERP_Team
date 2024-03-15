package com.erpproject.sixbeam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Paths;

@SpringBootApplication
public class  SixbeamApplication {
	private Process fastApiProcess;

	public static void main(String[] args) {
		SpringApplication.run(SixbeamApplication.class,args);
	}

	@PostConstruct
	public void startFastApiServer() {
		try {
			// 프로젝트 루트 경로를 기준으로 상대 경로 설정
			String venvPath = Paths.get(System.getProperty("user.dir"), "venv", "Scripts", "python.exe").toString();
			// FastAPI 서버 실행
			ProcessBuilder pb = new ProcessBuilder(venvPath, "-m", "uvicorn","main:app", "--reload");
			fastApiProcess = pb.start();

			System.out.println("FastAPI 서버가 시작되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("FastAPI 서버 시작에 실패했습니다.");
		}
	}

	@PreDestroy
	public void stopFastApiServer() {
		if (fastApiProcess != null) {
			fastApiProcess.destroy();
			System.out.println("FastAPI 서버가 종료되었습니다.");
		}
	}

}