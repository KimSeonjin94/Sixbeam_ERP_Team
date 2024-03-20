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
			System.out.println(venvPath);
			// FastAPI 서버 실행
			ProcessBuilder pb = new ProcessBuilder(venvPath, "-m" , "uvicorn","main:app", "--reload");

			pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
			pb.redirectError(ProcessBuilder.Redirect.INHERIT);

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
			ProcessHandle.of(fastApiProcess.pid())
					.ifPresent(processHandle -> {
						processHandle.descendants().forEach(ph -> {
							ph.destroy(); // 하위 프로세스 종료
							System.out.println("하위 프로세스 PID " + ph.pid() + " 가 종료되었습니다.");
						});
						processHandle.destroy(); // 메인 프로세스 종료
						System.out.println("FastAPI 서버 PID " + processHandle.pid() + " 가 종료되었습니다.");
					});
		}
	}

}