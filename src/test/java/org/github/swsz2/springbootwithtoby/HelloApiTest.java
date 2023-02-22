package org.github.swsz2.springbootwithtoby;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {
  @Test
  void shouldPassWhenEqualsResponseEntityAndExpectedValues() {

    final TestRestTemplate restTemplate = new TestRestTemplate();

    // given
    final String name = "Spring";
    final String expectedBody = "hello Spring";

    // when
    final ResponseEntity<String> responseEntity =
        restTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class, name);

    // then
    Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    Assertions.assertThat(responseEntity.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
    Assertions.assertThat(responseEntity.getBody()).isEqualTo(expectedBody);
  }
}
