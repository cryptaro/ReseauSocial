/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cryptaro
 */
@Repository("ConversationDAO")
public class ConversationDAOImpl implements ConversationDAO {
    @PersistenceContext(unitName="ReseauSocialPU")
    private EntityManager em;

    @Transactional
    @Override
    public void create(ConversationEntity conv) {
        em.persist(conv);
    }

    @Transactional
    @Override
    public List<ConversationEntity> getConversationByOwner(String login) {
        return (List<ConversationEntity>) em.createQuery("SELECT c FROM ConversationEntity c WHERE"
                + " c.owner = '"+ login+"'").getResultList();
    }

    @Transactional
    @Override
    public ConversationEntity getConversationById(Long id) {
        return (ConversationEntity) em.createQuery("SELECT c FROM ConversationEntity c WHERE"
                + " c.id =" + id).getSingleResult();
    }

    @Transactional
    @Override
    public List<ConversationEntity> getConversationByDate(Date d) {
        return (List<ConversationEntity>) em.createQuery("SELECT c FROM ConversationEntity c WHERE"
                + " c.date =" + d).getResultList();
    }

    @Transactional
    @Override
    public void removeConversation(ConversationEntity conversation) {
        conversation = em.merge(conversation);
        em.remove(conversation);
    }

    @Transactional
    @Override
    public List<ConversationEntity> getAllConversation() {
        return (List<ConversationEntity>) em.createQuery("SELECT c FROM ConversationEntity c ").getResultList();
    }
    
    @Transactional
    @Override
    public List<ConversationEntity> getConversationByVisibility(VisibilityEnum e){
        return (List<ConversationEntity>) em.createQuery("SELECT c FROM ConversationEntity c where"
                + " c.visibility = '" + e + "'").getResultList();
    }
    
    @Transactional
    @Override
    public List<ConversationEntity> getVisibleConversation(String login){
        return (List<ConversationEntity>) em.createQuery("SELECT c FROM ConversationEntity c where"
                + " c.owner = '" + login + "'"
                + " OR  c.visibility = '" + VisibilityEnum.Public + "'"
                + " OR (c.visibility = '" + VisibilityEnum.Private + "' AND '"+login+"' in  (select p from c.participants p) )").getResultList();
        // il manque le test de savoir si visible par les amis
    }

    @Override
    public boolean isVisibleConversation(String login) {
        return ((List<ConversationEntity>) em.createQuery("SELECT c FROM ConversationEntity c where"
                + " c.owner = '" + login + "' AND ("
                    + " c.visibility = '" + VisibilityEnum.Public + "'"
                    + " OR (c.visibility = '" + VisibilityEnum.Private + "' AND '"+login+"' in  (select p from c.participants p)"
                + ")").getResultList()).size()==1;
    }
    
}
