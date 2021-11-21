package com.shippingoo.domain.service;

import com.shippingoo.domain.PostRequest;
import com.shippingoo.domain.User;

import java.util.Date;
import java.util.List;

public interface PostRequestService {

    PostRequest findById(Long id);
    void removeById(Long id);
    void createPostRequest(PostRequest postRequest);
}
