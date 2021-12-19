package com.cdec.validator.service;

import com.cdec.validator.dal.model.EntryEntity;
import com.cdec.validator.dal.service.LinkDao;
import com.cdec.validator.dal.service.UserDao;
import com.cdec.validator.model.Entry;
import com.cdec.validator.model.ResponseStatus;
import com.cdec.validator.model.request.UpdateEntryRequest;
import com.cdec.validator.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LinkService {

    private final LinkDao linkDao;
    private final UserDao userDao;

    @Autowired
    public LinkService(LinkDao linkDao, UserDao userDao) {
        this.linkDao = linkDao;
        this.userDao = userDao;
    }

    public ResponseStatus updateResponse(UpdateEntryRequest request, String username) {

        String userId = this.userDao.getUserFromUserName(username).getId();

        this.linkDao.updateResponse(request.getId(), request.getResponse(),
                userId, TimeUtil.getCurrentTimeStamp());

        return ResponseStatus.SUCCESS;

    }

    public Entry getEntry(String username) {

        return fromEntity(
                linkDao.getLink(username)
        );

    }

    private String updateContext(String context){

        context = StringUtils.replace(context,"</a>","</b></u>");
        context = StringUtils.replace(context, "<a>","<u><b>");

        return context;

    }

    private Entry fromEntity(EntryEntity entity) {

        if (entity != null) {

            Entry entry = new Entry();
            entry.setContext(updateContext(entity.getContext()));
            entry.setId(entity.getId());
            entry.setLanguage(entity.getLanguage());
            entry.setNode(entity.getNode());
            entry.setInlinkTitle(entity.getInlinkTitle());
            entry.setWikipediaDescription(entity.getWikipediaDescription());
            entry.setWikipediaTitle(entity.getWikipediaTitle());

            return entry;
        } else return null;

    }

}
