package com.berk.first.helper;

import com.berk.first.model.User;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class UserHelper {

    public static void logUsername(final User user) {
        //burada herhangi bir işlem yapılabilirdi
        //sadece username logladım bunun kullanıldığı yere bakabilirsin

      log.debug(user.getName());

    }
}
