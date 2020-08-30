package cz.zk.kmshellozk;

import org.kurento.client.KurentoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@SpringBootApplication
@EnableWebSocket
public class KmsHelloZkApplication  implements WebSocketConfigurer {

	@Bean
	public Handler handler()
	{
		return new Handler();
	}

	@Bean
	public KurentoClient kurentoClient()
	{
		return KurentoClient.create("ws://kms:8888/kurento");
	}

	@Bean
	public ServletServerContainerFactoryBean createServletServerContainerFactoryBean() {
		ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
		container.setMaxTextMessageBufferSize(32768);
		return container;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
	{
		registry.addHandler(handler(), "/helloworld");
	}



	public static void main(String[] args) {
		SpringApplication.run(KmsHelloZkApplication.class, args);
	}

}
