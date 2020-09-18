package com.jzh.xx.transaction.service;

import com.jzh.xx.transaction.domain.Address;


public interface AddressService {
    Address getByUserId(Long userId);

}
