package uz.crud.crudinstructor.service;

import uz.crud.crudinstructor.dto.requestDto.ClassRoomRequestDto;
import uz.crud.crudinstructor.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    public String add(ClassRoomRequestDto classRoomRequestDto);

    public List<ClassRoom> getAllClassRoom();

    public ClassRoom getClassRoom(Long id);


    /*
    update
     */
    public ClassRoom updateClassRoom(Long id, ClassRoomRequestDto classRoomRequestDto);

    /*
    remove
     */

    public String deleteClassRoom(Long id);

}
