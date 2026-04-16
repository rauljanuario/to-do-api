package januario.to_do_api.dto.request;

public record RegisterUserRequest(String name, String email, String password) {
}
