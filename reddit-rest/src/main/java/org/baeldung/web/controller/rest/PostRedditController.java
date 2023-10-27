package org.baeldung.web.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.baeldung.reddit.persistence.service.IRedditService;
import org.baeldung.reddit.util.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/posts")
class PostRedditController {

    @Autowired
    private IRedditService redditService;

    // === API Methods

    @PostMapping
    @ResponseBody
    public final List<String> submit(@Valid @RequestBody final PostDto postDto) {
        return redditService.submitPost(postDto);
    }

    @GetMapping
    @ResponseBody
    public String checkIfAlreadySubmitted(@RequestParam("url") final String url, @RequestParam("sr") final String sr) {
        return redditService.checkIfAlreadySubmittedfinal(url, sr);
    }

}
