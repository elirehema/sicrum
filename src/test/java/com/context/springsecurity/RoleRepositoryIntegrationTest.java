package com.context.springsecurity;

import com.context.springsecurity.models.ERole;
import com.context.springsecurity.models.Role;
import com.context.springsecurity.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void whenFindByName_thenReturnBook() {
        //given
        Role role = new Role(ERole.ROLE_ADMIN);
        entityManager.persist(role);
        entityManager.flush();

        //when
        Optional<Role> found = roleRepository.findByName(role.getName());

        //then
        assertThat(found.get().getName())
                .isEqualTo(role.getName());

    }


}
