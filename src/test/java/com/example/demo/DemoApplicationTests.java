package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.Players;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldGetAllPlayers() {
		ResponseEntity<List> response = restTemplate.getForEntity("/api/players", List.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<Players> players = response.getBody();
		assertThat(players.size()).isEqualTo(19370);
	}

	@Test
	void shouldGetOnePlayer() {
		ResponseEntity<Players> response = restTemplate.getForEntity("/api/players/aardsda01", Players.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Players player = response.getBody();
		assertThat(player.getPlayerID()).isEqualTo("aardsda01");
	}

}
