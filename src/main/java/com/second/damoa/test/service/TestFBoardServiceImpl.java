package com.second.damoa.test.service;

import com.second.damoa.test.model.Boardtest;
import com.second.damoa.test.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TestFBoardServiceImpl implements TestFBoardService{

    private final TestRepository testRepository;

    @Override
    public Long saveGroup(Boardtest boardtest) throws Exception {
        Boardtest result = testRepository.save(boardtest);
        return result.getId();
    }

    @Override
    public List<Boardtest> list() throws Exception {
        List<Boardtest> boardInfoList = testRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        return boardInfoList;
    }

    @Override
    public Boardtest readList(Long id) throws Exception {
        Optional<Boardtest> boardtest = testRepository.findById(id);
        return boardtest.get();
    }
}
