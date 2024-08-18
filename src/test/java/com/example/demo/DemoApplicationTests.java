package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.model.Players;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	@DirtiesContext
	void shouldGetAllPlayers() {
		ResponseEntity<List> response = restTemplate.withBasicAuth("user","password").getForEntity("/api/players", List.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<Players> players = response.getBody();
		assertThat(players.size()).isEqualTo(19370);
	}

	@Test
	@DirtiesContext
	void shouldGetAllPlayersWithPagination() {
		ResponseEntity<List> response = restTemplate.withBasicAuth("user","password")
		.getForEntity("/api/players/paginated?page=0&size=10&sort=nameLast,asc", List.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<Players> players = response.getBody();
		assertThat(players.size()).isEqualTo(10);
	}

	@Test
	@DirtiesContext
	void shouldGetOnePlayer() {
		ResponseEntity<Players> response = restTemplate.withBasicAuth("user","password").getForEntity("/api/players/aardsda01", Players.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Players player = response.getBody();
		assertThat(player.getPlayerID()).isEqualTo("aardsda01");
	}

	@Test
	@DirtiesContext
	void shouldAddPlayer() {
		Players newPlayer = new Players();
		newPlayer.setPlayerID("janice123");
		newPlayer.setNameFirst("Janice");
		newPlayer.setNameLast("Dsouza");
		ResponseEntity<Void> response = restTemplate.withBasicAuth("user","password")
			.postForEntity("/api/players", newPlayer, Void.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

}
