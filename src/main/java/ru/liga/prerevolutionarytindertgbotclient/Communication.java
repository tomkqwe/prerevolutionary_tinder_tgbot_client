package ru.liga.prerevolutionarytindertgbotclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.liga.prerevolutionarytindertgbotclient.entity.User;

import java.util.List;
@Component
public class Communication {
    private final String URL = "http://localhost:8080/api/users/";
    @Autowired
    private RestTemplate restTemplate;

    public List<User> getAllUsers() {
        return restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        }).getBody();
    }

    public User getUser(int id) {
        return restTemplate.getForObject(URL + "/" + id, User.class);
    }

    public void saveUser(User user) {
        int id = user.getId();
        if (id == 0) {
            restTemplate.postForEntity(URL, user, String.class);
            System.out.println("New employee was added to DB");
        } else {
            restTemplate.put(URL, user);
            System.out.println("user with ID " + id + " was updated");
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
    }
}
