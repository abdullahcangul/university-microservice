package com.cngl.universtyservice.service;

import com.cngl.universtyservice.client.UniversityClient;
import com.cngl.universtyservice.dto.UniversityDetailDto;
import com.cngl.universtyservice.dto.UniversityDto;
import com.cngl.universtyservice.entity.University;
import com.cngl.universtyservice.entity.errorModel.NotFound;
import com.cngl.universtyservice.entity.errorModel.ServiceResult;
import com.cngl.universtyservice.repository.UniversityRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniverstyServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityClient universityClient;
    

    private final ModelMapper modelMapper;

    public UniverstyServiceImpl(UniversityRepository universityRepository, ModelMapper modelMapper, UniversityClient universityClient){
        this.universityClient=universityClient;
        this.universityRepository=universityRepository;
        this.modelMapper = modelMapper;
    }

    //Veritabanında kayıtlı tüm üniversiteleri  dönen method blogu
    @Override
    public List<UniversityDetailDto> findAll() {
        return modelMapper.map(universityRepository.findAll()
                .stream().map(x->modelMapper.map(x, UniversityDto.class)).collect(Collectors.toList()),new TypeToken<List<UniversityDetailDto>>() {}.getType());
    }

    //id si verilen üniversiteyi dönen kod blogu
    @Override
    public ServiceResult<UniversityDetailDto> getUniversity(int id) {

        ServiceResult<UniversityDetailDto> serviceResult=new ServiceResult<>();
        University university= universityRepository.getById(id);    
        //üniversite bulunduysa üniversiteyi dönen kod blogu
        if (university!=null){
            serviceResult.setResult(modelMapper.map(university,UniversityDetailDto.class));
            return serviceResult ;
        }
        //bulunamadı durumunda hata mesajı döndüren kod blogu
         NotFound notFound=new NotFound("error",id+" numaralı üniversite kaydı bulunamadı");
         serviceResult.setNotFound(notFound);
        return  serviceResult;


    }
    //Üniversite kaydı yapan kod blogu
    @Override
    public University save(University university) {
        university.setCreatedAt(new Date());
        university.setUpdatedAt(new Date());
        return universityRepository.save(university);
    }

    //Apiden üniversite listesi çeken kod blogu
    @Override
    public  List<University> getAllUniversity() {
        List<University> universities=universityClient.getAllUniversity();
        return universities;
    }


}

