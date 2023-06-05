package com.food.order.services;

import com.food.order.models.dto.MenuDTO;
import com.food.order.models.entities.Menu;
import com.food.order.repositories.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public MenuDTO createMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setName(menuDTO.getName());
        menu.setPrice(menuDTO.getPrice());

        Menu createdMenu = menuRepository.save(menu);

        return new MenuDTO(createdMenu.getMenuId(), createdMenu.getName(), createdMenu.getPrice());
    }

    public MenuDTO getMenuById(Long menuId) {
        return menuRepository.findById(menuId)
                .map(menu -> new MenuDTO(menu.getMenuId(), menu.getName(), menu.getPrice()))
                .orElse(null);
    }

    @Override
    public MenuDTO updateMenu(Long menuId, MenuDTO menuDTO) {
        return menuRepository.findById(menuId).map(menu -> {
            menu.setName(menuDTO.getName());
            menu.setPrice(menuDTO.getPrice());

            Menu updatedMenu = menuRepository.save(menu);

            return new MenuDTO(updatedMenu.getMenuId(), updatedMenu.getName(), updatedMenu.getPrice());
        }).orElse(null);
    }

    @Override
    public boolean deleteMenu(Long menuId) {
        return menuRepository.findById(menuId).map(menu -> {
            menuRepository.delete(menu);
            return true;
        }).orElse(false);
    }
}
