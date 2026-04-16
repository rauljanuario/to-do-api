package januario.to_do_api.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
