# Upgrade to Spring Boot 3.1, 3.2, 3.3

You can use this template to generate a new Grace application and upgrade it to Spring Boot 3.1, 3.2, 3.3.

### How to Use?

Grace `2023.0.0` provides Application Template to allow developers customize the generated project by using `--template` flag.

```bash
$ grace create-app \
grace.apps.springboot \
--template https://github.com/grace-templates/springboot.git
--boot-version=3.3.2
--enable-preview
```

or,

```bash
$ grace create-app \
grace.apps.springboot \
--template https://github.com/grace-templates/springboot/archive/refs/heads/main.zip
--boot-version=3.3.2
--enable-preview
```


### Support Versions

* Grace 2023.0.0+


### Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Plugins](https://github.com/grace-plugins)
- [Grace Guides](https://github.com/grace-guides)
