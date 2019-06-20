package com.study.shiro.session;

import com.study.shiro.util.JedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * RedisSessionDao .
 *
 * @author yanyue, 2019/6/20
 * @version shiro v1.0
 */
public class RedisSessionDao extends AbstractSessionDAO {

    private final String SHIRO_SESSION_PERFIX = "shiro-session";

    @Autowired
    private JedisUtil jedisUtil;

    private byte[] getKey(String key) {
        return (SHIRO_SESSION_PERFIX + key).getBytes();
    }

    private void saveSession(Session session) {
        if(session != null && session.getId()!=null){
            byte[] key = getKey(session.getId().toString());
            byte[] value = SerializationUtils.serialize(session);
            jedisUtil.set(key, value);
            jedisUtil.expire(key, 600);
        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session,sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            return null;
        }
        byte[] key = getKey(sessionId.toString());
        byte[] value = jedisUtil.get(key);
        return (Session) SerializationUtils.deserialize(value);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if(session ==null || session.getId()==null){
            return;
        }
        byte[] key=getKey(session.getId().toString());
        jedisUtil.del(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<byte[]> keys=jedisUtil.keys(SHIRO_SESSION_PERFIX);
        Set<Session> sessions=new HashSet<>();
        if(CollectionUtils.isEmpty(keys)){
            return sessions;
        }
        for(byte[] key:keys){
            Session session= (Session) SerializationUtils.deserialize(jedisUtil.get(key));
            sessions.add(session);
        }
        return sessions;
    }
}
