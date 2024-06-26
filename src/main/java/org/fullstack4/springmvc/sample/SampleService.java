package org.fullstack4.springmvc.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor
public class SampleService {

//    @Autowired // 생성자 만들 때 파라미터로 넣고 사용자 정의 생성자를 만든다.
//    private SampleDAO sampleDAO;

    @Qualifier("event")
    private final SampleDAO sampleDAO;

}