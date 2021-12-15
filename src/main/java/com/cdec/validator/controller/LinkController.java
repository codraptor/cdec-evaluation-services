package com.cdec.validator.controller;

import com.cdec.validator.model.Entry;
import com.cdec.validator.model.ResponseStatus;
import com.cdec.validator.model.request.UpdateEntryRequest;
import com.cdec.validator.service.LinkService;
import com.cdec.validator.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
public class LinkController {

    private final LinkService linkService;
    private final JWTUtil jwtUtil;

    @Autowired
    public LinkController(LinkService linkService, JWTUtil jwtUtil) {
        this.linkService = linkService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "/getEntry", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Entry> getEntry() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(this.linkService.getEntry(username));
    }


    @RequestMapping(value = "/updateEntry", method = RequestMethod.POST)
    public ResponseEntity<ResponseStatus> updateEntry(@RequestBody UpdateEntryRequest request) throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ResponseEntity<ResponseStatus> response = ResponseEntity.ok(linkService.updateResponse(request,username));
        return response;
    }

}
