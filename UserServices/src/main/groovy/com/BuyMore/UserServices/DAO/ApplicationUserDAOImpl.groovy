package com.BuyMore.UserServices.DAO

import com.BuyMore.UserServices.DTO.ApplicationUserDTO
import com.BuyMore.UserServices.Entity.ApplicationUser
import com.BuyMore.UserServices.Mapper.ApplicationUserMapper
import jakarta.persistence.EntityExistsException
import jakarta.persistence.EntityManager
import jakarta.persistence.NoResultException
import jakarta.persistence.PersistenceContext
import jakarta.persistence.TypedQuery
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Repository
class ApplicationUserDAOImpl implements ApplicationUserDAO {


    @PersistenceContext
    private EntityManager entityManager

    @Autowired
    ApplicationUserMapper mapper

    private static final Logger log = LogManager.getLogger(ApplicationUserDAO.class)

    @Autowired
    ApplicationUserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager
    }

    @Override
    Collection<ApplicationUser> findAll() throws Exception {
        try
        {
            TypedQuery<ApplicationUser> query = entityManager.createQuery("SELECT U FROM ApplicationUser U",ApplicationUser.class)
            return query.getResultList()
        }
        catch(Exception e)
        {
            log.error("${e.getClass()} : ${e.getMessage()}")
            throw e
        }
    }

    @Override
    ApplicationUser findById(Long id) throws NoResultException, Exception {
        try
        {
            TypedQuery<ApplicationUser> query = entityManager.createQuery("SELECT U FROM ApplicationUser U where U.id=:id",ApplicationUser.class)
            query.setParameter("id",id)
            return query.getSingleResult()
        }
        catch(NoResultException ignored)
        {
            throw ignored
        }
        catch(Exception e)
        {
            throw e
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    ApplicationUserDTO saveApplicationUser(ApplicationUserDTO  userDTO) throws EntityExistsException, IllegalArgumentException, Exception {
        try
        {
            ApplicationUser userToSave = mapper.applicationUserDTOToApplicationUser(userDTO)
            entityManager.persist(userToSave)
            return mapper.applicationUserToApplicationUserDTO(userToSave)
        }
        catch(EntityExistsException e)
        {
            throw e
        }
        catch(IllegalArgumentException e)
        {
            throw e
        }
        catch(Exception e)
        {
            throw e
        }

    }

    @Override
    ApplicationUserDTO updateApplicationUser(ApplicationUserDTO userDTO) {
        try
        {
            ApplicationUser userToUpdate = findById(userDTO.getUserID())
            mapper.updateApplicationUserFromDTO(userDTO,userToUpdate)
            entityManager.flush()
            return mapper.applicationUserToApplicationUserDTO(userToUpdate)
        }
        catch(EntityExistsException e)
        {
            throw e
        }
        catch(IllegalArgumentException e)
        {
            throw e
        }
        catch(Exception e)
        {
            throw e
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void deleteApplicationUser(ApplicationUserDTO userDTO) {

        try{
            entityManager.remove(mapper.applicationUserDTOToApplicationUser(userDTO))
        }
        catch(IllegalArgumentException e)
        {
            throw e
        }
        catch(Exception e)
        {
            throw e
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void deleteApplicationUserById(Long id)
    {
        try
        {
            ApplicationUser u = findById(id)
            entityManager.remove(u)
        }
        catch(NoResultException ignored)
        {
            throw ignored
        }
        catch(IllegalArgumentException e)
        {
            throw e
        }
        catch(Exception e)
        {
            throw e
        }
    }

}
