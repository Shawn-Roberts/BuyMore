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
            log.debug("ApplicationUser DAO - findAll ")
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
    ApplicationUser findById(String id) throws NoResultException, Exception {
        try
        {
            log.debug("ApplicationUser DAO - findById with argurments ${id} ")
            TypedQuery<ApplicationUser> query = entityManager.createQuery("SELECT U FROM ApplicationUser U where U.id=:id",ApplicationUser.class)
            query.setParameter("id",id)
            return query.getSingleResult()
        }
        catch(NoResultException ignored)
        {
            log.info("ApplicationUser DAO  - findById no result returned with id ${id}")
            throw ignored
        }
        catch(Exception e)
        {
            log.error("ApplicationUser DAO Error -findById with id ${id}")
            log.error("${e.getClass()} : ${e.getMessage()}")
            throw e
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    ApplicationUserDTO saveApplicationUser(ApplicationUserDTO  userDTO) throws EntityExistsException, IllegalArgumentException, Exception {
        try
        {
            log.debug("ApplicationUser DAO - saveApplicationUser")
            ApplicationUser user = mapper.applicationUserDTOToApplicationUser(userDTO)
            entityManager.persist(user)
            return mapper.applicationUserToApplicationUserDTO(user)
        }
        catch(EntityExistsException e)
        {
            log.error("ApplicationUser DAO - saveApplicationUser entity already exists ")
            throw e
        }
        catch(IllegalArgumentException e)
        {
            log.error("ApplicationUser DAO - saveApplicationUser IllegalArgurmentException ${e.getMessage()}")
            throw e
        }
        catch(Exception e)
        {
            log.error("ApplicationUser DAO - saveApplicationUser General Error: ${e.getClass()}: ${e.getMessage()}")
            throw e
        }

    }

    @Override
    ApplicationUser updateApplicationUser(ApplicationUser applicationUser) {
        try
        {
            log.debug("ApplicationUser DAO - updateApplicationUser")
            println applicationUser.getUniqueID()
            println applicationUser.getFirstName()
            println applicationUser.getLastName()
            entityManager.merge(applicationUser)
            return applicationUser
        }
        catch(EntityExistsException e)
        {
            log.error("ApplicationUser DAO - updateApplicationUser entity already exists ")
            throw e
        }
        catch(IllegalArgumentException e)
        {
            log.error("ApplicationUser DAO - updateApplicationUser IllegalArgurmentException ${e.getMessage()}")
            throw e
        }
        catch(Exception e)
        {
            log.error("ApplicationUser DAO - updateApplicationUser General Error: ${e.getClass()}: ${e.getMessage()}")
            throw e
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void deleteApplicationUserById(String id)
    {
        try
        {
            log.debug("ApplicationUser DAO - deleteApplicationUserById with params ${id}")
            ApplicationUser u = findById(id)
            deleteApplicationUser(u)
        }
        catch(NoResultException ignored)
        {
            log.info("ApplicationUser DAO  - deleteApplicationUserById no result returned with id ${id}")
            throw ignored
        }
        catch(IllegalArgumentException e)
        {
            log.error("ApplicationUser DAO - saveApplicationUser IllegalArgurmentException ${e.getMessage()}")
            throw e
        }
        catch(Exception e)
        {
            log.error("ApplicationUser DAO - deleteApplicationUserById General Error: ${e.getClass()}: ${e.getMessage()}")
            throw e
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void deleteApplicationUser(ApplicationUser applicationUser) {

        try{
            log.debug("ApplicationUser DAO - deleteApplicationUser")
            entityManager.remove(applicationUser)
        }
        catch(IllegalArgumentException e)
        {
            log.error("ApplicationUser DAO - deleteApplicationUser IllegalArgurmentException ${e.getMessage()}")
            throw e
        }
        catch(Exception e)
        {
            log.error("ApplicationUser DAO - deleteApplicationUser General Error: ${e.getClass()}: ${e.getMessage()}")
            throw e
        }

    }
}
