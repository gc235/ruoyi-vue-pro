package cn.iocoder.yudao.module.bpm.convert.message;

import cn.iocoder.yudao.module.system.api.mail.dto.MailSendSingleToUserReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface BpmMessageConvert {

    BpmMessageConvert INSTANCE = Mappers.getMapper(BpmMessageConvert.class);

    @Mapping(target = "toMails", ignore = true)
    @Mapping(target = "ccMails", ignore = true)
    @Mapping(target = "bccMails", ignore = true)
    @Mapping(target = "attachments", ignore = true)
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "templateCode", target = "templateCode")
    @Mapping(source = "templateParams", target = "templateParams")
    MailSendSingleToUserReqDTO convert(Long userId, String templateCode, Map<String, Object> templateParams);

}
