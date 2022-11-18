package com.tccmicronaut.service;


import com.tccmicronaut.model.User;
import com.tccmicronaut.repository.UserRepository;
import jakarta.inject.Inject;

import javax.transaction.Transactional;

public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


     public User create(User user) {
         try {
             return userRepository.save(user);
         } catch (Exception e) {
             throw new RuntimeException("Erro ao criar usuário");
         }
     }

        public User findById(String id) {
            try {
                return userRepository.findById(id).get();
            } catch (Exception e) {
                throw new RuntimeException("Erro ao buscar usuário");
            }
        }

        public void deleteById(String id) {
            try {
                userRepository.deleteById(id);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao deletar usuário");
            }
        }

        public User update(User user) {
            try {
                return userRepository.save(user);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar usuário");
            }
        }

        public Iterable<User> findAll() {
            try {
                return userRepository.findAll();
            } catch (Exception e) {
                throw new RuntimeException("Erro ao buscar todos os usuários");
            }
        }

        public User follow(String userFollowed, String userFollower) {
            try {
                User userFollowedObj = findById(userFollowed);
                User userFollowerObj = findById(userFollower);
                userFollowedObj.getFollowers().add(userFollowerObj.getId());
                userRepository.update(userFollowedObj);
                return userFollowedObj;
            } catch (Exception e) {
                throw new RuntimeException("Erro ao seguir usuário");
            }
        }

        public User unfollow(String userFollowed, String userFollower) {
            try {
                User userFollowedObj = userRepository.findById(userFollowed).get();
                User userFollowerObj = userRepository.findById(userFollower).get();
                userFollowedObj.getFollowers().remove(userFollowerObj.getId());
                userRepository.save(userFollowedObj);
                userRepository.save(userFollowerObj);
                return userFollowedObj;
            } catch (Exception e) {
                throw new RuntimeException("Erro ao deixar de seguir usuário");
            }
        }


}
