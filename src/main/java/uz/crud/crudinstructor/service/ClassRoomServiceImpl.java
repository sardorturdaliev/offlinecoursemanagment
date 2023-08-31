package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.crud.crudinstructor.dto.requestDto.ClassRoomRequestDto;
import uz.crud.crudinstructor.entity.ClassRoom;
import uz.crud.crudinstructor.repository.ClassRoomRepositry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    private final ClassRoomRepositry classRoomRepository;


    @Autowired
    public ClassRoomServiceImpl(ClassRoomRepositry classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }


    @Override
    public String add(ClassRoomRequestDto classRoomRequestDto) {
        if (classRoomRepository.existsByName(classRoomRequestDto.getName())) {
            return "already exists.";
        }
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName(classRoomRequestDto.getName());
        classRoom.setStatus(classRoomRequestDto.getStatus());
        classRoomRepository.save(classRoom);
        return "Success";
    }

    @Override
    public List<ClassRoom> getAllClassRoom() {
        List<ClassRoom> classRooms = new ArrayList<>();
        classRoomRepository.findAll().forEach(classRooms::add);
        return classRooms;
    }

    @Override
    public ClassRoom getClassRoom(Long id) {
        return classRoomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cound not found"));
    }

    @Transactional
    @Override
    public ClassRoom updateClassRoom(Long id, ClassRoomRequestDto classRoomRequestDto) {
        ClassRoom updateClassroom = getClassRoom(id);
        updateClassroom.setName(classRoomRequestDto.getName());
        updateClassroom.setStatus(classRoomRequestDto.getStatus());
        return updateClassroom;
    }

    @Override
    public String deleteClassRoom(Long id) {//2
        Optional<ClassRoom> optionalClassRoom = classRoomRepository.findById(id);
        if (optionalClassRoom.isPresent()){
            ClassRoom classRoom = getClassRoom(id);
            classRoomRepository.delete(classRoom);
            return "Deleted";
        }else {
            return "error with Id";
        }
    }



}
