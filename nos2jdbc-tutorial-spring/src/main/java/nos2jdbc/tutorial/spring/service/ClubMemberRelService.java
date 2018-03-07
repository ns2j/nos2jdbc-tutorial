package nos2jdbc.tutorial.spring.service;

import java.util.List;
import nos2jdbc.tutorial.spring.gen.entity.ClubMemberRel;
import nos2jdbc.tutorial.spring.gen.service.ClubMemberRelServiceBase;

import static nos2jdbc.tutorial.spring.gen.entity.names.ClubMemberRelNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClubMemberRelService extends ClubMemberRelServiceBase {
}
