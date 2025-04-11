package example.day04.fix.service;

import example.day04.fix.model.dto.FixDto;
import example.day04.fix.model.entity.FixEntity;
import example.day04.fix.model.repository.FixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FixService {

    private final FixRepository fixRepository;
    public FixDto fixSave(FixDto fixDto){

        FixEntity fixEntity = fixDto.toEntity();
        FixEntity saveEntity = fixRepository.save(fixEntity);
        if(saveEntity.getFid()>0){
            return saveEntity.fixDto();
        }else{
            return null;
        }

    }
    public List<FixDto> fixFindAll(){
//        List<FixEntity> fixEntityList = fixRepository.findAll();
//        List<FixDto> fixDtoList = new ArrayList<>();
//        for(int index=0;index<fixEntityList.size();index++){
//            FixDto fixDto = fixEntityList.get(index).fixDto();
//            fixDtoList.add(fixDto);
//        }
//        return fixDtoList;
        return fixRepository.findAll().stream().map(FixEntity::fixDto).collect(Collectors.toList());
    }
    public FixDto fixFindById(int fid){
//        Optional<FixEntity> optional = fixRepository.findById(fid);
//        if(optional.isPresent()){
//            FixEntity fixEntity = optional.get();
//            FixDto fixDto = fixEntity.fixDto();
//            return fixDto;
//        }
//        return null;
        return fixRepository.findById(fid).map(FixEntity::fixDto).orElse( null );
    }
    public FixDto fixUpdate(FixDto fixDto){
//        Optional<FixEntity>optional= fixRepository.findById(fixDto.getFid());
//        if(optional.isPresent()){
//            FixEntity fixEntity = optional.get();
//            fixEntity.setFname(fixDto.getFname());
//            fixEntity.setFdesc(fixDto.getFdesc());
//            fixEntity.setFquent(fixDto.getFquent());
//            return fixEntity.fixDto();
//        }
//        return null;
        return fixRepository.findById( fixDto.getFid() )
                .map(  (entity) -> { // 람다식 함수.  ()->{}
                            entity.setFname(fixDto.getFname() );
                            entity.setFdesc( fixDto.getFdesc()  );
                            entity.setFquent( fixDto.getFquent() );
                            return entity.fixDto();
                })
                    .orElse( null );


    }
    public boolean fixDelete (int fid){
//        boolean result = fixRepository.existsById(fid);
//        if(result ==true){
//            fixRepository.deleteById(fid);
//            return true;
//        }
//        return false;
        return fixRepository.findById( fid )
                .map( (entity) -> {
                    fixRepository.deleteById(fid);
                    return true;
                })
                .orElse( false );
    }
    public List<FixDto>fixFindByPage(int page,int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "fid"));
        return fixRepository.findAll(pageRequest).stream()
                .map(FixEntity::fixDto)
                .collect(Collectors.toList());
//       Page<FixEntity> fixEntityPage = fixRepository.findAll( pageRequest );
//        List< FixDto > fixDtoList = new ArrayList<>();
//        for( int index = 0 ; index < fixEntityPage.getContent().size() ; index++ ){
//            FixDto fixDto = fixEntityPage.getContent().get( index ).fixDto();
//            fixDtoList.add( fixDto );
//        }
//        return fixDtoList;
//    }
    }
}
