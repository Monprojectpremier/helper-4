package com.shippingoo.domain.service.impl;


import com.shippingoo.domain.PostRequest;
import com.shippingoo.domain.User;
import com.shippingoo.domain.service.PostRequestService;
import com.shippingoo.repository.PostRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostRequestImpl implements PostRequestService {

    @Autowired
    private PostRequestRepository postRequestRepository;


    @Override
    public PostRequest findById(Long id) {
        return postRequestRepository.findById(id).get();
    }



    @Override
    public void removeById(Long id) {
        postRequestRepository.deleteById(id);

    }

    @Override
    public void createPostRequest(PostRequest postRequest) {
        postRequestRepository.save(postRequest);
    }
}
