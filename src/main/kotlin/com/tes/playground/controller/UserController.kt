package com.tes.playground.controller

import com.tes.playground.domain.User
import com.tes.playground.mapper.UserMapper
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UserController(private val userMapper: UserMapper) {

    @GetMapping("/users")
    fun listUsers(model: Model): String {
        val users = userMapper.findAll()
        model.addAttribute("users", users)
        return "userList"
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long, model: Model): String {
        val user = userMapper.findById(id)
        model.addAttribute("user", user)
        return "userDetail"
    }

    @GetMapping("/users/new")
    fun newUserForm(model: Model): String {
        model.addAttribute("user", User(0, "", ""))
        return "userForm"
    }

    @PostMapping("/users")
    fun saveUser(user: User): String {
        if (user.id == 0L) {
            userMapper.insert(user)
        } else {
            userMapper.update(user)
        }
        return "redirect:/users"
    }
}
