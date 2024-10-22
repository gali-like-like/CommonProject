package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.entity.Result;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.scheduling.SchedulingAwareRunnable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="员工接口文档")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "根据id查询员工")
    @GetMapping("/users/id/{id}")
    public Result getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    @Operation(summary = "根据名字模糊查询用户")
    @GetMapping("/users/name/{name}")
    public Result getUsersByName(@PathVariable String name) {
        List<User> users = userService.getUsersByName(name);
        return Result.success(users);
    }

    @Operation(summary = "查询全部员工")
    @GetMapping("/users")
    public Result getUsers() {
        List<User> users = userService.getUsers();
        return Result.success(users);
    }

    @Operation(summary = "修改用户信息")
    @PutMapping("/user")
    public Result save(@Validated @RequestBody User user) {
        userService.save(user);
        return Result.success(null);
    }

    @Operation(summary = "添加员工信息")
    @PostMapping("/user")
    public Result add(@Validated @RequestBody User user) {
        Integer id = userService.insert(user);
        return Result.success(id);
    }

    @Operation(summary = "根据id删除员工")
    @DeleteMapping("/user")
    public Result deleteById(@Validated @NotNull(message = "id不能为空") Integer id) {
        userService.deleteById(id);
        return Result.success(null);
    }
}
