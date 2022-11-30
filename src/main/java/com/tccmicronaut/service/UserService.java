package com.tccmicronaut.service;


import com.tccmicronaut.model.User;
import com.tccmicronaut.repository.UserRepository;
import jakarta.inject.Inject;

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
        	 e.printStackTrace();
             throw new RuntimeException("Erro ao criar usuário");
         }
     }

        public User findById(Long id) {
            try {
                return userRepository.findById(id).get();
            } catch (Exception e) {
           	 e.printStackTrace();
                throw new RuntimeException("Erro ao buscar usuário");
            }
        }

        public void deleteById(Long id) {
            try {
                userRepository.deleteById(id);
            } catch (Exception e) {
           	 e.printStackTrace();
                throw new RuntimeException("Erro ao deletar usuário");
            }
        }

        public User update(User user) {
            try {
                return userRepository.save(user);
            } catch (Exception e) {
           	 e.printStackTrace();

                throw new RuntimeException("Erro ao atualizar usuário");
            }
        }

        public Iterable<User> findAll() {
            try {
                return userRepository.findAll();
            } catch (Exception e) {
            	e.printStackTrace();
                throw new RuntimeException("Erro ao buscar todos os usuários");
            }
        }    
}
