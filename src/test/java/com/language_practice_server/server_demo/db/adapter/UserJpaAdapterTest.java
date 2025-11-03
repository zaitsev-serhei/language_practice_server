package com.language_practice_server.server_demo.db.adapter;

import com.language_practice_server.server_demo.db.entity.UserEntity;
import com.language_practice_server.server_demo.db.repository.UserRepositoryJpa;
import com.language_practice_server.server_demo.domain.model.User;
import com.language_practice_server.server_demo.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests that UserJpaAdapter (.db.adapter.) correctly delegates repository operations
 * (finding, saving, deleting) and properly maps between User(domain level) and UserEntity(db level)
 */
@ExtendWith(MockitoExtension.class)
public class UserJpaAdapterTest {
    @Mock
    private UserRepositoryJpa userRepositoryJpa;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserJpaAdapter userJpaAdapter;

    private User user;
    private UserEntity userEntity;
    private final Long id = 1L;
    private final String username = "username";

    @BeforeEach
    void setUp() {
        user = new User();
        userEntity = new UserEntity();
    }

    @Test
    void shouldFindUserById() {
        when(userRepositoryJpa.findById(id)).thenReturn(Optional.of(userEntity));
        when(userMapper.toModel(userEntity)).thenReturn(user);

        Optional<User> result = userJpaAdapter.findUserById(id);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());

        verify(userRepositoryJpa).findById(id);
        verify(userMapper).toModel(userEntity);
    }

    @Test
    void shouldFindUserByUserName() {
        when(userRepositoryJpa.findByUserName(username)).thenReturn(Optional.of(userEntity));
        when(userMapper.toModel(userEntity)).thenReturn(user);

        Optional<User> result = userJpaAdapter.findUserByUserName(username);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());

        verify(userRepositoryJpa).findByUserName(username);
        verify(userMapper).toModel(userEntity);
    }

    @Test
    void shouldSaveUser() {
        when(userMapper.toEntity(user)).thenReturn(userEntity);
        when(userRepositoryJpa.save(userEntity)).thenReturn(userEntity);
        when(userMapper.toModel(userEntity)).thenReturn(user);

        User result = userJpaAdapter.saveUser(user);

        assertEquals(user, result);
        verify(userMapper).toEntity(user);
        verify(userRepositoryJpa).save(userEntity);
        verify(userMapper).toModel(userEntity);
    }

    @Test
    void shouldDeleteUserById() {
        userJpaAdapter.deleteUserById(id);

        verify(userRepositoryJpa).deleteById(id);
    }
}
