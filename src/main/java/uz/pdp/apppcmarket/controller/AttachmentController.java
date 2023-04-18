package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.service.AttachmentService;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;
    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request){
        Result result = attachmentService.uploadFile(request);
        return result;
    }
    @GetMapping
    public List<Attachment> getAttachments(){
        List<Attachment>attachmentList =attachmentService.getAttachments();
        return attachmentList;
    }@DeleteMapping
    public Result deleteAttachment(@PathVariable Integer id){
        Result result = attachmentService.deleteAttachment(id);
        return result;
    }@PutMapping
    public Result editAttachment(@RequestBody Attachment attachment,@PathVariable Integer id){
        Result result = attachmentService.editAttachment(attachment, id);
        return result;

    }
}
